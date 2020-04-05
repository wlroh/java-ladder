package ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLine> lines;

    private Ladder(final List<LadderLine> lines) {
        validate(lines);
        this.lines = Collections.unmodifiableList(lines);
    }

    private void validate(final List<LadderLine> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            throw new IllegalArgumentException("Ladder Line must be existed.");
        }
    }

    public static Ladder newInstance(final int count, final int height) {
        return newInstance(new MemberCount(count), LadderHeight.newInstance(height));
    }

    public static Ladder newInstance(final MemberCount memberCount, final LadderHeight height) {
        List<LadderLine> ladders = IntStream.range(0, height.toInt())
                .mapToObj(i -> LadderLine.newInstance(memberCount))
                .collect(Collectors.toList());
        return new Ladder(ladders);
    }

    public List<LadderLine> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(getLines(), ladder.getLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLines());
    }
}