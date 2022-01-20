package de.hallorebux.bawt;

/**
 * Represents a size or offset that can be retrieved relative to some value
 *
 * @author Nils Osswald
 */
public interface SizeReference
{
    /**
     * Retrieves the size or offset relative to the parameter.
     * @return the retrieved value 
     *
     * @param relativeTo the value that the value retrieved should be relative to
     */
    int get(int relativeTo);
}
