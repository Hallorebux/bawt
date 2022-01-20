# (B)etter (A)bstract (W)indow (T)oolkit
![Issues](https://img.shields.io/github/issues-raw/hallorebux/bawt)
![Last commit](https://img.shields.io/github/last-commit/hallorebux/bawt/main)
![License](https://img.shields.io/github/license/hallorebux/bawt)
![Stars](https://img.shields.io/github/stars/hallorebux/bawt?style=social)

BAWT is a [Java](https://www.java.com/) library for building complex user interfaces.

* **Component Based**: Allows you to build encapsulated components, then compose them to make complex user interfaces.
* **Cross Platform**: Since BAWT is based on the original java AWT package, it also has support for Windows, Linux and Mac OS X.
* **Built-In Components**: BAWT comes with a package that contains lots of different default components you can work with.
* **Theme System**: It also comes with a built-in theme system that supports `.json` configuration files, that can be changed without modifying your projects source code.

## 💾 Installation

The library can be included via a `.jar` file in your prefered IDE:

### InteliJ Idea

1. Navigate to `File` > `Project Structure` > `Modules` > `Dependencies`
2. Click the `+` icon
3. Select the `JARs or directories` option
4. Import the [downloaded]() `.jar` file

### Eclipse

1. Right click on the Project
2. Select `Build Path` > `Configure Build Path`
3. Under `Libraries` click `Add External JARs..`
4. Select the [downloaded]() `.jar` file

## 📰 Documentation

The documentation and further examples for BAWT can be found in the [docs](/docs) directory inside the projects root folder.

The documentation is divided into multiple sections:

* Creating a `Frame` and adding a `Screen`: [getting_started.md](docs/getting_started.md)
* Creating custom `Component`s: [component_guide.md](docs/component_guide.md)
* Using `relative` and `absolute` sizes: [sizing_guide.md](docs/sizing_guide.md)
* Using built-in `Component`s: [default_components.md](docs/default_components.md)
* Implementing different `Theme`s: [theme_guide.md](docs/theme_guide.md)

> Documentation for single classes can be found [here](docs/classes)

> JavaDoc exports are located [here](docs/javadoc)

## 🧩 Examples

### Simple Frame
```java
Frame frame = new Frame("Title", 800, 600, true, false);
frame.setVisible(true);
```

### Centered Component
```java
Frame frame = new Frame();
Component component = new ExampleComponent(
                new RelativeSize(.25F),
                new RelativeSize(.25F),
                new RelativeSize(.5F),
                new RelativeSize(.5F)
);

frame.getCurrentScreen().addComponent(component);

frame.setVisible(true);
```

## ⚖️ License

This project is licensed under the MIT License - see the [LICENSE](/LICENSE) file for details