/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.dcc.dcc093.expressao.antlr.grammar.java;

import br.ufjf.dcc.dcc093.expressao.antlr.grammar.java.output.JavaLexer;
import br.ufjf.dcc.dcc093.expressao.antlr.grammar.java.output.JavaParser;
import br.ufjf.dcc.dcc093.expressao.antlr.grammar.java.output.JavaParserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

/**
 *
 * @author gleiph
 */
public class MeuVisitorJava extends JavaParserBaseVisitor<Object> {

    private boolean escopoAtributo = false;

    private void imprimeDados(ParserRuleContext ctx) {
        int beginLine = ctx.start.getLine();
        int endLine = ctx.stop.getLine();

        System.out.println("begin ===> " + beginLine);
        System.out.println("end ===> " + endLine);
    }

    @Override
    public Object visitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {

        this.escopoAtributo = true;
        Object visitFieldDeclaration = super.visitFieldDeclaration(ctx);
        this.escopoAtributo = false;

        return visitFieldDeclaration;
    }

    @Override
    public Object visitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {

        if (this.escopoAtributo) {
            String identificador = ctx.variableDeclaratorId().getText();
            System.out.println("========================== atributo:" + identificador + " ====================================");
            imprimeDados(ctx);
        }
        return super.visitVariableDeclarator(ctx);
    }

    @Override
    public Object visitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
        String identificador = ctx.identifier().getText();
        System.out.println("========================== construtor:" + identificador + " ====================================");
        imprimeDados(ctx);
        return super.visitConstructorDeclaration(ctx);
    }

    @Override
    public Object visitGenericConstructorDeclaration(JavaParser.GenericConstructorDeclarationContext ctx) {
        String identificador = ctx.constructorDeclaration().identifier().getText();
        System.out.println("========================== construtor:" + identificador + " ====================================");
        imprimeDados(ctx);
        return super.visitGenericConstructorDeclaration(ctx);
    }

    @Override
    public Object visitGenericMethodDeclaration(JavaParser.GenericMethodDeclarationContext ctx) {
        String identificador = ctx.methodDeclaration().identifier().getText();
        System.out.println("========================== method:" + identificador + " ====================================");
        imprimeDados(ctx);
        return super.visitGenericMethodDeclaration(ctx);
    }

    @Override
    public Object visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        String identificador = ctx.identifier().getText();
        System.out.println("========================== method:" + identificador + " ====================================");
        imprimeDados(ctx);
        return super.visitMethodDeclaration(ctx);
    }

    @Override
    public Object visitAnnotationContext(JavaParser.AnnotationContext ctx) {

        System.out.println("AQUI" + ctx.getTokens(JavaLexer.COMMENT));

        // Continue visitando os filhos deste contexto
        return visitChildren(ctx);
    }


}
