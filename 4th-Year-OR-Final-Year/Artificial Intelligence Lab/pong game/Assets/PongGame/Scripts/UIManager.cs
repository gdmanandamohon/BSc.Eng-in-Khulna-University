using UnityEngine;
using System.Collections;

public class UIManager : MonoBehaviour
{
    public GameObject scren;
    public GameObject pauseScreen;

    public void Retry(string scene)
    {
        print("ks");
        scren.SetActive(false);
        Application.LoadLevel(scene);
    }
    public void Load(string scene)
    {
        Application.LoadLevel(scene);
    }
    public void Quit()
    {
        Application.Quit();
    }

    public void Resume()
    {
        pauseScreen.SetActive(false);
        Time.timeScale = 1;
    }

    public void Pause()
    {
        pauseScreen.SetActive(true);
        Time.timeScale = 0;
    }

    
}
