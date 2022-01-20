package de.hallorebux.bawt;

/**
 * Represents a {@link SizeReference} that is relative to its parent
 * <code>Component</code> or <code>Screen</code>
 *
 * @author Nils Osswald
 */
public final class RelativeSize implements SizeReference
{
    private float factor;

    /**
     * Creates a <code>RelativeSize</code> that always returns its value
     * based on the given <code>factor</code> multiplied on its parent
     * <code>Screen</code> or <code>Component</code> size
     *
     * @param factor the relative factor
     */
    public RelativeSize(float factor)
    {
        this.factor = factor;
    }

    @Override
    public int get(int relativeTo)
    {
        return (int)(relativeTo * factor);
    }
}
