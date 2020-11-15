using UnityEngine;
using System.Collections;

public class PlayerMovement : MonoBehaviour
{
    public bool leftPlayer;
    public bool rightPlayer;

    public float speed;
    private Vector3 playerPos;

    // Use this for initialization
    void Start ()
    {
        //playerPos = transform.position;
	    
	}
	
	// Update is called once per frame
	void Update ()
    {
        if(leftPlayer)
        {
           
             float yPos = transform.position.y + (Input.GetAxis("LeftPlayer") * speed);
             playerPos = new Vector3(-7.3f, Mathf.Clamp(yPos, -3f, 5f), 0f);           
             transform.position = playerPos;
            
        }
        if(rightPlayer)
        {
            float yPos = transform.position.y + (Input.GetAxis("RightPlayer") * speed);
            playerPos = new Vector3(7.3f, Mathf.Clamp(yPos, -3f, 5f), 0f);
            transform.position = playerPos;
        }
	
	}
}
