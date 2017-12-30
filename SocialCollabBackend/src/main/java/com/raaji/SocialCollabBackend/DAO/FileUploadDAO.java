package com.raaji.SocialCollabBackend.DAO;


import com.raaji.SocialCollabBackend.Model.FileUpload;

public interface FileUploadDAO 
{
	public void save(FileUpload fileUpload, String username);
	public FileUpload getFile(String username);
}
