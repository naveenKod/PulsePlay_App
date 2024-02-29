package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Songs;

public interface SongsService  {
	public String addSongs(Songs song);
	public boolean songExists(String name);

	public List<Songs> fetchAllSongs();


	public void updateSong(Songs song);
}