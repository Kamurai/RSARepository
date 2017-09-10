//Masom Hamadeh
//CS3540 - Final Question #4

//NOTE: summary of items that were added to allow for doubly linked features
	//added private variable "mhBehind" (to allow for viewing previous/before element)
	//edited constructor to allow for this newly added variable "mhBehind"
	//added getters and setters for newly added variable "mhBehind"

package masom_dll;

public class Linkable<G>
{
	private Linkable<G> right;
	private Linkable<G> mhBehind; //Added for DOUBLY LINKED 
	private G g;
	
	public Linkable(G g, Linkable<G> right, Linkable<G> mhBehind) //fixed contstructor to allow for doubly linked elements
	{
		this.mhBehind = mhBehind;
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
	//addition of set and get methods for "mhBehind" to allow for doubly linked
	public Linkable<G> getBehind() {
		return mhBehind;
	}
	
	public void setBehind(Linkable<G> mhBehind) {
		this.mhBehind = mhBehind;
	}	
}
