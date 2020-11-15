using UnityEngine;
using System.Collections;

public class ObstacleMovement : MonoBehaviour 
{
    Rigidbody2D rbody;

	// Use this for initialization
	void Start () 
    {
        rbody = GetComponent<Rigidbody2D>();
        rbody.velocity = new Vector2(Random.Range(1, 5), Random.Range(0, 7));
	}
	
	// Update is called once per frame
	void Update () 
    {
        //transform.position += new Vector3
	}


}
