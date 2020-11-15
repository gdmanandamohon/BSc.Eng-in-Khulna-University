using UnityEngine;
using System.Collections;

public class AI : MonoBehaviour
{
    public Transform theBall;
    public float velocityLevel;
    float ballPosX, balPosY,random;
    Transform CurrentTransform;
    float balVelX;
    void Start()
    {
        CurrentTransform = this.transform;
    }

    void FixedUpdate()
    {
        balPosY = theBall.position.y;
        balVelX = theBall.GetComponent<PongBall>().speed;

        if (balVelX != 0)
        {
            if (balPosY > GetComponent< Rigidbody2D > ().position.y + 0.2)
            {

                GetComponent<Rigidbody2D>().velocity = new Vector2(0, velocityLevel);
            }
            else if (balPosY < GetComponent< Rigidbody2D > ().position.y - 0.2)
            {
                GetComponent<Rigidbody2D>().velocity = new Vector2(0, -velocityLevel);
            }
            else
            {
                GetComponent<Rigidbody2D>().velocity = Vector2.zero;
            }
        }
        else {
            if (GetComponent< Rigidbody2D > ().position.y > 0.1f &&
                    GetComponent< Rigidbody2D > ().position.y < -0.1f)
            {
                GetComponent<Rigidbody2D>().velocity = new Vector2(0, -velocityLevel);
            }
            else if (GetComponent< Rigidbody2D > ().position.y < -0.1f &&
                  GetComponent< Rigidbody2D > ().position.y < 0.1f)
            {
                GetComponent<Rigidbody2D>().velocity = new Vector2(0, velocityLevel);
            }

        }
    }

}