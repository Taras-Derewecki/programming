using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class respawn : MonoBehaviour {

    public static int levelN = 0;

    private Vector3 startPos;
    private Quaternion startRot;

	// Use this for initialization
	void Start () {
        startPos = transform.position;
        startRot = transform.rotation;
	}

    void nextLevel()
    {
        levelN++;
        if (levelN > 1)
        {
            levelN = 0;
        }

        SceneManager.LoadScene(levelN);

    }

    void OnTriggerEnter(Collider other)
    {
        if (other.tag == "death")
        {
            transform.position = startPos;
            transform.rotation = startRot;

            GetComponent<Animator>().Play("LOSE00", -1, 0f);
            GetComponent<Rigidbody>().velocity = new Vector3(0f, 0f, 0f);
            GetComponent<Rigidbody>().angularVelocity = new Vector3(0f, 0f, 0f);
        }
        else if (other.tag == "Checkpoint")
        {
            startPos = other.transform.position;
            startRot = other.transform.rotation;
            Destroy(other.gameObject);
        }
        else if (other.tag == "Goal")
        {
            GetComponent<Animator>().Play("WIN00", -1, 0f);
            Destroy(other.gameObject);
            Invoke("nextLevel", 2f);
        }
    }

    // Update is called once per frame
    void Update () {
		
	}
}
