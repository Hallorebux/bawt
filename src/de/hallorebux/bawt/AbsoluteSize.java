package de.hallorebux.bawt;

/**
 * Represents a <code>SizeReference</code> that is absolute 
 * based on the screen resolution
 *
 * @author Nils Osswald
 */
public final class AbsoluteSize implements SizeReference
{
    private int value;

    /**
     * Creates a <code>AbsoluteSize</code> that always returns it absolute value
     *
     * @param value a non-decimal absolute location measured in pixels
     */
    public AbsoluteSize(int value)
    {
        this.value = value;
    }

    @Override
    public int get(int relativeTo)
    {
        return value;
    }
}
