# PixelCraft

PixelCraft is a Java-based command-line image processing application that applies different image converters to PNG images and saves the processed result automatically with a new filename.

This project focuses on digital image processing, object-oriented design, and clean Java implementation using inheritance.

## Features

PixelCraft supports multiple image converters, including:

- `Grayscale` — converts the image to grayscale
- `Rotate` — rotates the image 90 degrees clockwise
- `Blur` — applies a simple blur effect
- `Invert` — inverts image colours
- `Mirror` — mirrors the image horizontally
- `Warmer` — makes the image warmer by increasing red tones
- `Darker` — darkens the image

## Project Structure

```text
PixelCraft/
├── src/
│   ├── PixelCraft.java
│   ├── Converter.java
│   ├── ARGB.java
│   ├── Grayscale.java
│   ├── Rotate.java
│   ├── Blur.java
│   ├── Invert.java
│   ├── Mirror.java
│   ├── Warmer.java
│   └── Darker.java
├── images/
│   └── toronto.png
└── out/
```

## Requirements

- Java 21 or a compatible JDK
- PNG image input

## Compile

```bash
mkdir -p out && javac -d out src/*.java
```

## How to Run

General format:

```bash
java -cp out PixelCraft [ConverterName] [input_image.png]
```

Example:

```bash
java -cp out PixelCraft Grayscale images/toronto.png
java -cp out PixelCraft Rotate images/toronto.png
java -cp out PixelCraft Blur images/toronto.png
java -cp out PixelCraft RecursiveMirror images/toronto.png
java -cp out PixelCraft RecursiveInvert images/toronto.png
java -cp out PixelCraft Invert images/toronto.png
java -cp out PixelCraft Warmer images/toronto.png
java -cp out PixelCraft Darker images/toronto.png
```