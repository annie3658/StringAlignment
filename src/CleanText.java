import java.util.Objects;

public class CleanText {

    private Integer cleanStartOffset;
    private Integer cleanEndOffset;
    private String text;

    public Integer getCleanStartOffset() {
        return cleanStartOffset;
    }

    public void setCleanStartOffset(Integer cleanStartOffset) {
        this.cleanStartOffset = cleanStartOffset;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCleanEndOffset() {
        return cleanEndOffset;
    }

    public void setCleanEndOffset(Integer cleanEndOffset) {
        this.cleanEndOffset = cleanEndOffset;
    }

    public CleanText(Integer cleanStartOffset, Integer cleanEndOffset, String text) {
        this.cleanStartOffset = cleanStartOffset;
        this.cleanEndOffset = cleanEndOffset;
        this.text = text;
    }

    @Override
    public String toString() {
        return "CleanText{" +
                "cleanStartOffset=" + cleanStartOffset +
                ", cleanEndOffset=" + cleanEndOffset +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CleanText cleanText = (CleanText) o;
        return cleanStartOffset.equals(cleanText.cleanStartOffset) &&
                cleanEndOffset.equals(cleanText.cleanEndOffset) &&
                text.equals(cleanText.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cleanStartOffset, cleanEndOffset, text);
    }
}
