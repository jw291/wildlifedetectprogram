package com.example.wildlifedetectprogram;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

enum AnimalType {
    ELK(1), WILD_BOAR(2), RACCOONS(3), CHIPMUNK(4), SQUIRREL(5), BLACK_BEAR(6),
    WEASEL(7), RABBIT(8), HERON(9), GREAT_EGRET(10), ROE_DEER(11);

    private final int value;
    private static Map map = new HashMap<>();

    static {
        for (AnimalType pageType : AnimalType.values()) {
            map.put(pageType.value, pageType);
        }
    }

    AnimalType(int number) {
        this.value = number;
    }

    public static AnimalType valueOf(int pageType) {
        return (AnimalType) map.get(pageType);
    }
}
class SoundPathFactory
{
    public static int ELK_SoundPath = R.raw.a;
    public static int WILDBOARS_oundPath = R.raw.b;
    public static int RACCOONS_SoundPath = R.raw.c;
    public static int CHIPMUNK_SoundPath = R.raw.d;
    public static int SQUIRREL_SoundPath = R.raw.e;
    public static int BLACKBEAR_SoundPath = R.raw.f;
    public static int WEASEL_SoundPath = R.raw.g;
    public static int RABBIT_SoundPath = R.raw.h;
    public static int HERON_oundPath = R.raw.i;
    public static int GREATEGRET_SoundPath = R.raw.j;
    public static int ROEDEER_SoundPath = R.raw.k;
}

public class SoundManager {
    private static final SoundManager instance = new SoundManager();

    private SoundManager() {}

    public static SoundManager getInstance() {
        return instance;
    }

    private MediaPlayer mediaPlayer;

    public void PlaySound(Context context, int animalID)
    {
        AnimalType type = AnimalType.valueOf(animalID);
        switch (type)
        {
            case ELK:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.ELK_SoundPath);
                break;
            case WILD_BOAR:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.WILDBOARS_oundPath);
                break;
            case RACCOONS:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.RACCOONS_SoundPath);
                break;
            case CHIPMUNK:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.CHIPMUNK_SoundPath);
                break;
            case SQUIRREL:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.SQUIRREL_SoundPath);
                break;
            case BLACK_BEAR:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.BLACKBEAR_SoundPath);
                break;
            case WEASEL:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.WEASEL_SoundPath);
                break;
            case RABBIT:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.RABBIT_SoundPath);
                break;
            case HERON:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.HERON_oundPath);
                break;
            case GREAT_EGRET:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.GREATEGRET_SoundPath);
                break;
            case ROE_DEER:
                mediaPlayer = MediaPlayer.create(context, SoundPathFactory.ROEDEER_SoundPath);
                break;
        }

        OnPlaySoundWithTimer();
    }

    TimerTask timerTask;
    private void OnPlaySoundWithTimer()
    {
        OnPlaySound();
        StartTimer();
    }

    private void OnPlaySound()
    {
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                ReleaseSound();
            }
        });
    }

    private void StartTimer()
    {
        StopTimer();

        int startTime = 30;
        int endTime = 0;
        timerTask = new TimerTask()
        {
            int count = startTime;

            @Override
            public void run()
            {
                count--;
                if(count <= endTime)
                {
                    ReleaseSound();
                }
            }
        };
    }

    private void StopTimer()
    {
        if(timerTask != null)
        {
            timerTask.cancel();
            timerTask = null;
        }
    }

    public void StopSound()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
    }

    public void ReleaseSound()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
