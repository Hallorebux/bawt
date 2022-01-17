package de.hallorebux.bawt;

/**
 * @author Nils Osswald
 */
public final class AbsoluteSize implements SizeReference
{
    private int value;

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
