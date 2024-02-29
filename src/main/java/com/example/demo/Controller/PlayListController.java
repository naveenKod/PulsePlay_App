package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.PlayList;
import com.example.demo.Entity.Songs;
import com.example.demo.Service.PlayListService;
import com.example.demo.Service.SongsService;



@Controller
public class PlayListController 
{
	@Autowired
	PlayListService pserv;

	@Autowired
	SongsService sserv;

	@GetMapping("/createplaylist")
	public String createPlayList(Model model) {

		//Fetching the songs using song service
		List<Songs> songslist=sserv.fetchAllSongs();

		//Adding the songs in the model
		model.addAttribute("songslist",songslist);

		//sending createplaylist
		return "createplaylist";
	}

	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		//adding playlist
		pserv.addPlaylist(playlist);

		//update song table

		List<Songs> songsList= playlist.getSongs();
		for(Songs song : songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}

		return "playlistsuccess";
	}


	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		List<PlayList> plist= pserv.fetchPlaylists();
	//	System.out.println(plist);
		model.addAttribute("plist", plist);
		return "viewPlaylist";
	}

}



