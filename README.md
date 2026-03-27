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
│   ├── RecursiveMirror.java
│   ├── RecursiveInvert.java
│   ├── Warmer.java
│   └── Darker.java
├── images/
│   └── toronto.png
└── out/
```

## Class Descriptions

Below are brief descriptions of the main Java classes in `src/`:

- `PixelCraft.java`: The entry point. Uses reflection to instantiate the `Converter` class specified on the command line, runs the conversion, and saves the output file by appending `_<ConverterName>` to the original filename.
- `Converter.java`: Abstract base class that handles image I/O, provides utility helpers (`createEmptyImage`, `clamp`), and defines the abstract `process` method implemented by each converter.
- `ARGB.java`: Utility for decomposing an integer ARGB pixel into alpha, red, green, and blue channels and reassembling them back into an `int` pixel value.
- `Grayscale.java`: Converts an image to grayscale by averaging the red, green, and blue channels for each pixel.
- `Rotate.java`: Rotates the image 90 degrees clockwise (output width and height are swapped).
- `Blur.java`: Applies a simple 3x3 box blur by averaging neighboring pixels' ARGB components, with boundary checks at the image edges.
- `Invert.java`: Inverts the color of each pixel by replacing each channel with `255 - value`.
- `RecursiveInvert.java`: Inverts the entire image's colors; implemented with a helper that processes pixels by scanning rows and columns.
- `RecursiveMirror.java`: Mirrors the image horizontally using recursive row/column processing.
- `Warmer.java`: Makes the image appear warmer by increasing the red channel (e.g., +30) and decreasing the blue channel (e.g., -20), with values clamped to the 0–255 range.
- `Darker.java`: Darkens the image by scaling each color channel down (implemented by multiplying channels by 0.7).

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