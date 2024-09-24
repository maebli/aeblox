package io.github.maebli.lox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class GenerateAst {
    public static void main(String[] args) throws IOException {
        String outputDir;
        if (args.length != 1) {
            System.out.println("Usage: generate_ast <output directory>");
            outputDir = "./jlox/lox/src/main/java/io/github/maebli/lox";
            System.out.println("Using default <output_directory> = " + outputDir);
        } else {
            outputDir = args[0];
        }

        defineAst(outputDir, "Expr", Arrays.asList(
                "Binary : Expr left, Token operator, Expr right",
                "Grouping : Expr expression",
                "Literal: Object value ",
                "Unary : Token operator, Expr right"));
    }

    private static void defineAst(
            String outputDir, String baseName, List<String> types)
            throws IOException {
        String path = outputDir + "/" + baseName + ".java";
        try (PrintWriter writer = new PrintWriter(path, "UTF-8")) {
            writer.println("package io.github.maebli.lox;");
            writer.println();
            writer.println("import java.util.List;");
            writer.println();

            writer.println("abstract class " + baseName + " {");

            defineVisitor(writer, baseName, types);

            for (String type : types) {
                String className = type.split(":")[0].trim();
                String fieldList = type.split(":")[1].trim();
                defineType(writer, baseName, className, fieldList);
            }
            writer.println();
            writer.println("   abstract <R> R accept(Visitor<R> vistor);");
            writer.println("}");

        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
            System.err.println("Hint, you are currently in the dir: " + System.getProperty("user.dir"));
        }
    }

    private static void defineType(PrintWriter writer, String baseName, String className, String fieldList) {
        writer.println("  static class " + className + " extends " + baseName + " {");

        // Constructor
        writer.println("    " + className + "(" + fieldList + ") {");

        // Store parameters in fields.
        String[] fields = fieldList.split(", ");
        for (String field : fields) {
            String name = field.split(" ")[1];
            writer.println("      this." + name + " = " + name + ";");
        }

        writer.println("   }");

        for (String field : fields) {
            writer.println("   final " + field + ";");
        }

        // Vistor pattern
        writer.println();
        writer.println("   @Override");
        writer.println("   <R> R accept(Visitor<R> vistor){");
        writer.println("          return vistor.visit" + className + baseName + "(this);");
        writer.println("   }");

        writer.println("  }");

    }

    private static void defineVisitor(
            PrintWriter writer, String baseName, List<String> types) {
        writer.println("   interface Visitor<R> {");

        for (String type : types) {
            String typeName = type.split(":")[0].trim();
            writer.println("     R visit" + typeName + baseName + "(" + typeName + " " + baseName.toLowerCase() + ");");
        }

        writer.println("  }");

    }
}
