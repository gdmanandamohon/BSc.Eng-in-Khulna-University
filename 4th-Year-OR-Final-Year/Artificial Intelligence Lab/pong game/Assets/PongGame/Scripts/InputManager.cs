using UnityEngine;
using System.Collections;

public class InputManager : MonoBehaviour
{
    Vector3 initPos;

	// Use this for initialization
	void Start ()
    {
        initPos = transform.position;
	}
	
	// Update is called once per frame
	void Update ()
    {
        Vector3 pos = Camera.main.ScreenToWorldPoint(Input.mousePosition);
        pos.z = 0;
        pos.x = initPos.x;
        transform.position = new Vector3(pos.x,Mathf.Clamp(pos.y,-2.3f,4.5f),0);
	
	}
}
