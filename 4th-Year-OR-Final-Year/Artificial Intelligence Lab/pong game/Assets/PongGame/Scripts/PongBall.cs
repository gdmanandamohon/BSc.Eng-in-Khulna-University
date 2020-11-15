using UnityEngine;
using System.Collections.Generic;
using UnityEngine.UI;

public class PongBall : MonoBehaviour
{
    public float speed;
    bool action;
    Rigidbody2D rb;
    public GameObject screen;
    public Text left;
    public Text right;
    int leftPoint = 0;
    int rightPoint = 0;
    PlayerManager p;
    List<PlayerManager> playerList;
    
	// Use this for initialization
	void Start ()
    {

        rb = GetComponent<Rigidbody2D>();
        PlayerPrefs.SetString("Player", "User");
        PlayerPrefs.SetInt("Score", 0);
        p = new PlayerManager();
        playerList = new List<PlayerManager>();
	}
	
	// Update is called once per frame
	void Update ()
    {
        if (Input.GetButtonDown("Fire1") && action == false)
        {
            Vector3 source = transform.position;
            Vector3 to = new Vector3(0, Random.Range(-5, 5), 0);
            Vector3 net = to - source;
            //net = Vector3.Normalize(net);
            transform.parent = null;
            action = true;
            rb.isKinematic = false;
            rb.AddForce(speed * net);
        }
        left.text = leftPoint.ToString();
        right.text = rightPoint.ToString();

        if(leftPoint > PlayerPrefs.GetInt("Score"))
        {
            PlayerPrefs.SetInt("finalScore", leftPoint);
            //PlayerPrefs.SetString("Player", PlayerInfor.playername);
        }
        if(Input.GetKeyDown(KeyCode.Escape))
        {
            Application.Quit();
        }
    }

    void OnCollisionEnter2D(Collision2D coll)
    {
        if (coll.gameObject.tag == "Death")
        {
            screen.SetActive(true);
           /* p.name = PlayerPrefs.GetString("Player");
            p.score = PlayerPrefs.GetInt("Score");
            playerList.Add(p);
            playerList.Sort();
            //print(PlayerPrefs.GetString("Player"));*/
        }
        if(coll.transform.name == "Left")
        {
            leftPoint++;
        }
        if (coll.transform.name == "Right")
        {
            rightPoint++;
        }

    }

}
