package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.PlayList;

public interface PlayListService 
{

	public void addPlaylist(PlayList playlist);

	public List<PlayList> fetchPlaylists();

}
