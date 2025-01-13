package resources;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.util.regex.Pattern;

public class TextFont {

    private static final int DEFAULT_FONT_SIZE = 256;
    private static final String LINEBREAK = "\n";
    private UnicodeFont baseFont;
    private String text;


    public TextFont(TextFont font)
    {
        this.baseFont = font.baseFont;
    }

    private TextFont(UnicodeFont font)
    {
        this.baseFont = font;
    }

    public static TextFont fromTTF(String filepath, boolean bold, boolean italic) throws SlickException
    {
        UnicodeFont font = new UnicodeFont(filepath, DEFAULT_FONT_SIZE, bold, italic);
        font.getEffects().add(new ColorEffect(java.awt.Color.white));
        font.addAsciiGlyphs();
        font.loadGlyphs();

        return new TextFont(font);
    }

    public void drawString(Graphics g, String text, float x, float y)
    {
        g.setFont(this.baseFont);
        g.drawString(text, x, y);
        this.text = text;
        g.resetFont();
    }

    public void drawString(Graphics g, String text, float x, float y, float size)
    {
        float scale = size / DEFAULT_FONT_SIZE;
        g.setFont(this.baseFont);
        g.scale(scale, scale);
        g.drawString(text, x / scale, y / scale);
        this.text = text;
        g.resetTransform();
        g.resetFont();
        System.out.println(x  + " " + y);

        System.out.println(x / scale + " " + y/scale);
    }

    public void drawStringCentered(Graphics g, String text, float x, float y)
    {
        float halfWidth = this.baseFont.getWidth(text) / 2f;
        float halfHeight = this.baseFont.getHeight(text) / 2f;

        g.setFont(this.baseFont);
        g.drawString(text, x - halfWidth, y - halfHeight);
        this.text = text;
        g.resetFont();
    }

    public void drawStringCentered(Graphics g, String text, float x, float y, float size)
    {
        float scale = size / DEFAULT_FONT_SIZE;

        float halfWidth = (this.baseFont.getWidth(text) * scale) / 2f;
        float halfHeight = (this.baseFont.getHeight(text) * scale) / 2f;

        g.setFont(this.baseFont);
        g.scale(scale, scale);
        g.drawString(text, (x - halfWidth) / scale, (y - halfHeight) / scale);
        this.text = text;
        g.resetTransform();
        g.resetFont();
    }
    public void wrap(Graphics g, String text, float x, float y, float w, float size) {
        float scale = size / DEFAULT_FONT_SIZE;
        g.setFont(this.baseFont);
        g.scale(scale, scale);
        this.text = text;

        StringBuilder b = new StringBuilder();
        for (String line : text.split(Pattern.quote(LINEBREAK))) {
            b.append(wrapLine(g, line, w, scale));
        }
        g.drawString(b.toString(), x / scale, y / scale);
        g.resetTransform();
        g.resetFont();
    }

    private static String wrapLine(Graphics g, String line, float width, float scale) {
        if (line.isEmpty()){
            return LINEBREAK;
        }
        if (g.getFont().getWidth(line) * scale <= width){
            return line + LINEBREAK;
        }
        String[] words = line.split(" ");
        StringBuilder allLines = new StringBuilder();
        StringBuilder trimmedLine = new StringBuilder();
        for (String word : words) {
            if ((g.getFont().getWidth(trimmedLine + " ") + g.getFont().getWidth(word)) * scale <= width) {
                trimmedLine.append(word).append(" ");
            } else {
                allLines.append(trimmedLine).append(LINEBREAK);
                System.out.println(width);
                System.out.println(g.getFont().getWidth(trimmedLine.toString()) * scale);

                trimmedLine = new StringBuilder();
                trimmedLine.append(word).append(" ");
            }
        }
        if (!trimmedLine.isEmpty()) {
            allLines.append(trimmedLine);
        }
        allLines.append(LINEBREAK);
        return allLines.toString();
    }
    public int getPixelWidth()
    {
        return baseFont.getWidth(text);
    }
    public float getHeight(Graphics g, String text, float w, float size) {
        float scale = size / DEFAULT_FONT_SIZE;
        g.setFont(this.baseFont);
        g.scale(scale, scale);

        int lineCount = 1;


        for (String line : text.split(Pattern.quote(LINEBREAK))) {
            String wrapped = wrapLine(g, line, w, scale);
            lineCount += wrapped.split(Pattern.quote(LINEBREAK)).length - 1;
        }
        float lineHeight = g.getFont().getLineHeight();
        g.resetTransform();
        g.resetFont();

        return lineCount * lineHeight * scale;
    }
}
