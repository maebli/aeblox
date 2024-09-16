package io.github.maebli.lox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.github.maebli.lox.TokenType.BANG;
import static io.github.maebli.lox.TokenType.BANG_EQUAL;
import static io.github.maebli.lox.TokenType.COMMA;
import static io.github.maebli.lox.TokenType.DOT;
import static io.github.maebli.lox.TokenType.EOF;
import static io.github.maebli.lox.TokenType.GREATER;
import static io.github.maebli.lox.TokenType.GREATER_EQUAL;
import static io.github.maebli.lox.TokenType.IDENTIFIER;
import static io.github.maebli.lox.TokenType.LEFT_BRACE;
import static io.github.maebli.lox.TokenType.LEFT_PARENTHESIS;
import static io.github.maebli.lox.TokenType.LESS;
import static io.github.maebli.lox.TokenType.LESS_EQUAL;
import static io.github.maebli.lox.TokenType.MINUS;
import static io.github.maebli.lox.TokenType.NUMBER;
import static io.github.maebli.lox.TokenType.PLUS;
import static io.github.maebli.lox.TokenType.RIGHT_BRACE;
import static io.github.maebli.lox.TokenType.RIGHT_PARENTHESIS;
import static io.github.maebli.lox.TokenType.SEMICOLON;
import static io.github.maebli.lox.TokenType.SLASH;
import static io.github.maebli.lox.TokenType.STAR;
import static io.github.maebli.lox.TokenType.STRING;

public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    private int start = 0;
    private int current = 0;
    private int line = 1;

    public Scanner(String source) {
        this.source = source;
    }

    public List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }
        tokens.add(new Token(EOF, "", null, line));
        return tokens;
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '(' -> addToken(LEFT_PARENTHESIS);
            case ')' -> addToken(RIGHT_PARENTHESIS);
            case '{' -> addToken(LEFT_BRACE);
            case '}' -> addToken(RIGHT_BRACE);
            case ',' -> addToken(COMMA);
            case '.' -> addToken(DOT);
            case '-' -> addToken(MINUS);
            case '+' -> addToken(PLUS);
            case ';' -> addToken(SEMICOLON);
            case '*' -> addToken(STAR);
            case '!' -> addToken(match('=') ? BANG_EQUAL : BANG);
            case '=' -> addToken(match('=') ? BANG_EQUAL : BANG);
            case '<' -> addToken(match('=') ? LESS : LESS_EQUAL);
            case '>' -> addToken(match('=') ? GREATER : GREATER_EQUAL);
            case '/' -> {
                if (match('/')) {
                    while (peek() != '\n' && !isAtEnd())
                        advance();
                } else {
                    addToken(SLASH);
                }
            }
            case ' ', '\r', '\t' -> {
                // ignore
            }
            case '\n' -> line++;
            case '"' -> string();
            default -> {
                if (Character.isDigit(c)) {
                    number();
                } else if (Character.isAlphabetic(c)) {
                    identifier();
                } else {
                    Lox.error(line, "Illegal character found in source: '" + c + "'");
                }
            }
        }

    };

    private void identifier() {
        while (Character.isLetterOrDigit(peek()))
            advance();
        String text = source.substring(start, current);
        TokenType type = keywords.get(text);
        if (type == null)
            type = IDENTIFIER;
        addToken(type);
    }

    private void number() {
        while (Character.isDigit(peek()))
            advance();

        if (peek() == '.' && Character.isDigit(peekNext())) {
            advance();

            while (Character.isDigit(peek()))
                advance();
        }
        addToken(NUMBER, Double.valueOf(source.substring(start, current)));
    }

    private char peekNext() {
        if (current + 1 >= source.length())
            return '\0';
        return source.charAt(current + 1);
    }

    private void string() {

        while (peek() != '"' && !isAtEnd()) {
            if (peek() == '\n')
                line++;
            advance();
        }

        if (isAtEnd()) {
            Lox.error(line, "Unterminated string.");
            return;
        }

        advance();

        String value = source.substring(start + 1, current - 1);
        addToken(STRING, value);
    }

    private char peek() {
        if (isAtEnd())
            return '\0';
        return source.charAt(current);
    }

    private boolean match(char expected) {
        if (isAtEnd())
            return false;
        if (source.charAt(current) != expected)
            return false;
        current++;
        return true;
    }

    private void addToken(TokenType type) {
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private char advance() {
        return source.charAt(current++);
    }

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap<>();
        keywords.put("and", TokenType.AND);
        keywords.put("class", TokenType.CLASS);
        keywords.put("else", TokenType.ELSE);
        keywords.put("false", TokenType.FALSE);
        keywords.put("for", TokenType.FOR);
        keywords.put("fun", TokenType.FUN);
        keywords.put("if", TokenType.IF);
        keywords.put("nil", TokenType.NIL);
        keywords.put("or", TokenType.OR);
        keywords.put("print", TokenType.PRINT);
        keywords.put("return", TokenType.RETURN);
        keywords.put("super", TokenType.SUPER);
        keywords.put("this", TokenType.THIS);
        keywords.put("true", TokenType.TRUE);
        keywords.put("var", TokenType.VAR);
        keywords.put("while", TokenType.WHILE);
    }
}
