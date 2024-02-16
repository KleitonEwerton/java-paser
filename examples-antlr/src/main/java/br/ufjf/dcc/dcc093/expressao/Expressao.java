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

/**
 *
 * @author gleiph
 */
public class Expressao {

    private static final boolean SHOW_TREE = true;

    public static void main(String[] args) throws IOException {

            java("C:/Users/kleit/OneDrive/Documentos/ANTLR-Example/src/main/java/br/ufjf/dcc/dcc093/expressao/Expressao.java", false);
    }

    /*comentario*/
    public static void java(String filePath, boolean printTree) throws IOException, OutOfMemoryError {

        //Aqui tem comentario
        if (filePath.endsWith(".java")) {

            /*
            * deee
            * */

            // Teste

            CharStream charContent = CharStreams.fromFileName(filePath);

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

    public static void javaPaser(String[] args) {



    }

    private static class CommentReportEntry {
        private String type;
        private String text;
        private int lineNumber;
        private boolean isOrphan;

        CommentReportEntry(String type, String text, int lineNumber, boolean isOrphan) {
            this.type = type;
            this.text = text;
            this.lineNumber = lineNumber;
            this.isOrphan = isOrphan;
        }

        @Override
        public String toString() {
            return lineNumber + "|" + type + "|" + isOrphan + "|" + text.replaceAll("\\n","").trim();
        }
    }
}
