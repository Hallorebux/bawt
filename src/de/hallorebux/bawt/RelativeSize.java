package de.hallorebux.bawt;

/**
 * @author Nils Osswald
 */
public final class RelativeSize implements SizeReference
{
    private float factor;

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
