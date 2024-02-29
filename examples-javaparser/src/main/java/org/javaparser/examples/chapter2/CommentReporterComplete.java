package org.javaparser.examples.chapter2;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.Path;
import java.nio.file.FileSystems;


public class CommentReporterComplete {

    private static final String FILE_PATH =
            "src/main/java/org/javaparser/samples/MeuTeste.java";

    public static void main(String[] args) throws Exception {
        String projectPath = "src";
        Files.walk(FileSystems.getDefault().getPath(projectPath))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".java"))
                .forEach(CommentReporterComplete::processJavaFile);


    }


    private static class CommentReportEntry {
        private String type;
        private String text;
        private int startLine;
        private int endLine;
        private boolean isOrphan;

        CommentReportEntry(String type, String text, int startNumber, int endNumber, boolean isOrphan) {
            this.type = type;
            this.text = text;
            this.startLine = startNumber;
            this.endLine = endNumber;
            this.isOrphan = isOrphan;
        }

        @Override
        public String toString() {
            return startLine + " to " + endLine + " | " + type + " | " + isOrphan + " | " + text.replaceAll("\\n","").trim();
        }
    }
    public static void processJavaFile(Path filePath) {
        try{
        CompilationUnit cu = StaticJavaParser
                .parse(filePath);

        List<CommentReportEntry> comments = cu.getAllContainedComments()
                .stream()
                .map(p -> new CommentReportEntry(p.getClass().getSimpleName(),
                        p.getContent(),
                        p.getRange().map(r -> r.begin.line).orElse(-1),
                        p.getRange().map(r -> r.end.line).orElse(-1),
                        !p.getCommentedNode().isPresent()))
                .collect(Collectors.toList());

            System.out.println(filePath.toString());
        comments.forEach(System.out::println);
    }catch(Exception e){
            e.printStackTrace();
        }
    }
}
