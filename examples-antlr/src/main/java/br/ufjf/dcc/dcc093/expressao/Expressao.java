package br.ufjf.dcc.dcc093.expressao;

import org.antlr.v4.runtime.*;

import br.ufjf.dcc.dcc093.expressao.antlr.grammar.java.MeuVisitorJava;
import br.ufjf.dcc.dcc093.expressao.antlr.grammar.java.output.JavaLexer;
import br.ufjf.dcc.dcc093.expressao.antlr.grammar.java.output.JavaParser;
import java.io.IOException;

import org.antlr.v4.runtime.tree.ParseTree;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.comments.Comment;

public class Expressao {

    private static final boolean SHOW_TREE = true;

    public static void main(String[] args) throws IOException {

        java("C:/Users/kleit/OneDrive/Documentos/java-paser/examples-antlr/src/main/java/br/ufjf/dcc/dcc093/expressao/Expressao.java",
                false);
    }

    /* comentario */
    public static void java(String filePath, boolean printTree) throws IOException, OutOfMemoryError {

        // Aqui tem comentario
        if (filePath.endsWith(".java")) {
            // comentarios para teste
            CharStream charContent = CharStreams.fromFileName(filePath);

            // comentarios para teste
            JavaLexer lexer = new JavaLexer(charContent);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            JavaParser parser = new JavaParser(tokens);

            ParseTree tree;

            try {
                tree = parser.compilationUnit();
            } catch (OutOfMemoryError ex) {
                throw ex;
            }
            MeuVisitorJava visitor = new MeuVisitorJava();

            visitor.visit(tree);

        } else {
            throw new IOException();
        }
    }

}
