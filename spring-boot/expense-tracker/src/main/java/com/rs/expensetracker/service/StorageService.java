package com.rs.expensetracker.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    Integer persistRecords(MultipartFile expenseFile);
}
