package linkedlist;

public class Linkable<G>
{

	private Linkable<G> right;
	private Linkable<G> left;
	private G g;
	public Linkable(Linkable<G> left, G g, Linkable<G> right)
	{
		this.left = left;
		this.right = right;
		this.g = g;
	}
	public G getG()
	{
		return g;
	}
	public void setG(G g)
	{
		this.g = g;
	}
	public Linkable<G> getRight()
	{
		return right;
	}
	public void setRight(Linkable<G> right)
	{
		this.right = right;
	}
	public Linkable<G> getLeft()
	{
		return left;
	}
	public void setLeft(Linkable<G> left)
	{
		this.left = left;
	}
	
}
