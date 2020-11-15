using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class Player
{

    
}
public class PlayerInfor : MonoBehaviour
{
    public static string playername;
    public InputField playernameTextbox;
    Player p;
	// Use this for initialization
	void Start ()
    {
        //playernameTextbox.Select();
        DontDestroyOnLoad(this);

	}
	
	// Update is called once per frame
	void Update ()
    {
	    
	}
    public void Play()
    {
        playername = playernameTextbox.text;
        print(playername);
        Application.LoadLevel("Main");
    }
}
