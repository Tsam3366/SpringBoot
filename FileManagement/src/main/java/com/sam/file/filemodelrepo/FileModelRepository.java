package com.sam.file.filemodelrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.file.model.FileModel;

@Repository
public interface FileModelRepository extends JpaRepository<FileModel,Long>{

}
