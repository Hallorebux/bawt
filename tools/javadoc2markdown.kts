/**
 * Extracts javadoc comments out of a given .java file
 * and writes those into a markdown file.
 * Usage: javadoc2markdown.kts <input> <outputFolder>
 *
 * @author Nils Osswald
 */

import java.io.File

if (args.size != 2) {
    println("Please provide an input and output folder!")
    System.exit(-1)
}

val input: String = args[0]
val output: String = args[1]

if (input.endsWith(".java"))
    convertFile(File(input))
else {
    File(input).walk()
        .filter { it.name.endsWith(".java") }
        .forEach { convertFile(it) }
}

fun convertFile(file: File) {
    val name = file.name.split(".")[0]
    val lines = file.readLines().map { it
        .replace("<code>", "`").replace("</code>", "`")
        .replace("@return", "Returns")
    }
    
    var javadocComments: List<Pair<String, List<String>>> = 
        lines.withIndex().filter { it.value.contains("/**") }
            .map { it.index }
            .map { it..it+lines.drop(it).indexOfFirst { it.contains("*/") } }
            .map { range ->
                Pair(
                    lines[range.endInclusive+1].trim(),
                    range.map { lines[it]
                        .replace("*", "")
                        .replace("/", "")
                        .trim() 
                    }.toList().filter { it.isNotEmpty() }
                )
             }.toList()
    
    val header = javadocComments.first().second
    val authors: List<String> = 
        header.filter { it.contains("@author") }
            .map { it.split("@author")[1].trim() }
    val description: String = 
        (0..header.indexOfFirst { it.contains("@author") }-1)
            .map { header[it] }
            .joinToString(separator = " ")        

    val outputFile = File(output, "${name}.md")

    // remove class comment
    javadocComments = javadocComments.drop(1);

    outputFile.createNewFile()
    outputFile.printWriter().use { out ->
        out.println("# $name")
        out.println("[Source](../${file.path})\n")
        out.println(description)
        out.println("___")

        val constructors = javadocComments.filter { 
            it.first.split("(")[0].split(" ").last().equals(name)
        }
        if (constructors.isNotEmpty()) {
            out.println("## Constructor(s)")
            constructors.forEach {
                out.println("```java")
                out.println(it.first)
                out.println("```")
                out.println("### Description")
                out.println(it.second.filter { s -> !s.contains("@param") }
                    .joinToString(separator = " "))
                val parameters = it.second.filter { s -> s.contains("@param") }
                if (parameters.isNotEmpty()) {
                    out.println("### Parameters")
                    parameters.forEach { p ->
                        val temp = p.split(" ")
                        out.println("- *${temp[1]}*: ${temp.drop(2).joinToString(" ")}")
                    }
                }
            }
            out.println("___")
        }

        val functions = javadocComments.filter { it !in constructors }
        if (functions.isNotEmpty()) {
            out.println("## Functions")
            functions.forEach {
                out.println("```java")
                out.println(it.first)
                out.println("```")
                out.println("### Description")
                out.println(it.second.filter { s -> !s.contains("@param") }
                    .joinToString(separator = " "))
                val parameters = it.second.filter { s -> s.contains("@param") }
                if (parameters.isNotEmpty()) {
                    out.println("### Parameters")
                    parameters.forEach { p ->
                        val temp = p.split(" ")
                        out.println("- *${temp[1]}*: ${temp.drop(2).joinToString(" ")}")
                    }
                }
            }
            out.println("___")
        }

        out.println("> Author(s): ${authors.joinToString(", ")}")
    }

    println("Wrote ${outputFile.path}")
}