package me.zhengjie.yuangan.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.domain.LocalStorage;
import me.zhengjie.service.LocalStorageService;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.SecurityUtils;
import me.zhengjie.yuangan.bean.FileList;
import me.zhengjie.yuangan.bean.FilePath;
import me.zhengjie.yuangan.bean.QuestionBank;
import me.zhengjie.yuangan.service.FileUploadzwService;
import me.zhengjie.yuangan.service.TestPaperService;
import me.zhengjie.yuangan.service.dto.FileUploadQueryCriteria;
import me.zhengjie.yuangan.service.dto.QuestionQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: ZhouW
 * @Description:
 * @Date: Created in 11:02 2020/12/25
 */
@RestController
@RequestMapping("api/fileUploadzw")
public class FileUploadzw {

    @Autowired
    FileUploadzwService fileUploadzwService;

    @Autowired
    LocalStorageService localStorageService;

//    @ApiOperation("上传文件")
//    @PostMapping(value = "/insert")
//    public ResponseEntity<Object> publicFile(@RequestBody FileList fileList){
//
//        System.out.println(fileList);
//        fileList.setFileUserId(SecurityUtils.getCurrentUsername());
//        if (null == fileList.getFileId()) {
//            fileUploadzwService.addFile(fileList);
//        } else {
//            fileUploadzwService.updateFile(fileList);
//        }
//        return new ResponseEntity<Object>(HttpStatus.CREATED);
//
//    }
    @ApiOperation("上传文件")
    @PostMapping(value = "/insert")
    public ResponseEntity<Object> publicFile(@RequestParam MultipartFile file){
        System.out.println(file);
        System.out.println("----上传-");
        LocalStorage name = localStorageService.create("name", file);
        System.out.println(name);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping("/findAllFile")
    public ResponseEntity<Object> findAllNotes(FileUploadQueryCriteria map, Pageable pageable){
        System.out.println(map.getName());
        PageHelper.startPage(pageable.getPageNumber()+1,pageable.getPageSize());
        List<FileList> questDtos =  fileUploadzwService.queryFileUploadList(map);
        PageInfo<FileList> page = new PageInfo<>(questDtos);
        return new ResponseEntity<Object>(PageUtil.toPage(page.getList(),page.getTotal()), HttpStatus.OK);
    }


    @GetMapping("/findAllFilePersonById")
    public ResponseEntity<Object> findAllFilePersonById(FileList map){
        System.out.println(map);
        List<FilePath> questDtos =  fileUploadzwService.queryFileUploadPersonListById(map.getFileId());
        PageInfo<FilePath> page = new PageInfo<>(questDtos);
        return new ResponseEntity<Object>(PageUtil.toPage(page.getList(),page.getTotal()), HttpStatus.OK);
    }
}
