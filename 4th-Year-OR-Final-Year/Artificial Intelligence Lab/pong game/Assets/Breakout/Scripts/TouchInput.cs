using UnityEngine;
using System.Collections;

public class TouchInput : MonoBehaviour
{
    private float speed;
    // Use this for initialization
    void Start ()
    {
       
    }
	
	// Update is called once per frame
	void Update ()
    {
        if (Input.touchCount > 0 && Input.GetTouch(0).phase == TouchPhase.Moved)
        {
            Vector2 touchDeltaPosition = Input.GetTouch(0).deltaPosition;
            //Input.GetTouch(0).radius
            transform.Translate(0, touchDeltaPosition.y * speed, 0);
        }

    }
}
