package me.zhengjie.yuangan.controller; /**
 * Created by Super on 2020/8/10.
 */

import me.zhengjie.utils.PageUtil;
import me.zhengjie.yuangan.bean.User;
import me.zhengjie.yuangan.service.User1Service;
import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/10 10:58
 */
@RestController
@RequestMapping("api/user1")
public class User1Controller {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(User1Controller.class);
    @Autowired
    private User1Service userService;

//    @Autowired
//    private CommonDetailsService commonService;

//    @RequestMapping("/queryUserList")
//    public ResponseEntity<Object> queryUserList(@RequestBody Map<String,Object> map){
//        System.out.println(map);
//        PageHelper.startPage((Integer) map.get("pageIndex"),(Integer)map.get("pageSize"));
//        String user =  map.get("user")==""?"":map.get("user").toString();
//        String dept =  map.get("dept")==""?"":map.get("dept").toString();
//        String role =  map.get("role")==""?"":map.get("role").toString();
//        String job =  map.get("job")==""?"":map.get("job").toString();
//        System.out.println(user);
//        PageInfo<User> list = new PageInfo<>(userService.queryUserList(user,dept,role,job));
//        String json = JsonDataUtils.getJson(list.getList());
//        JSONObject result = new JSONObject();
//        result.put("employees",list.getList());
//        result.put("pages",list.getPages());
//        result.put("total",list.getTotal());
//        return new ResponseEntity<Object> (200, "成功", result);
//    }
//    @PostMapping("/add")
//    public ResponseEntity<Object>  toAdd(@RequestBody User user){
//        return     userService.addUser(user);
//    }
//    @RequestMapping("/update")
//    public ResponseEntity<Object>  toUpdate(@RequestBody User user){
//
//        return  new ResponseEntity<Object> (200, "成功", userService.updateUser(user));
//    }
//
//    @RequestMapping("/deleteUser")
//    public ResponseEntity<Object>  deleteUser( @RequestBody Map<String,Object> map){
//
//        System.out.println(map.get("id"));
//        boolean flag = userService.deleteUser( map.get("id").toString());
//        if(flag){
//            return  new ResponseEntity<Object> (200, "删除成功", flag);
//        }
//        return  new ResponseEntity<Object> (201, "删除失败", flag);
//    }
//    @RequestMapping("UploadFile")
//    @ResponseBody
//    public ResponseEntity<Object>  UploadFile(@RequestBody MultipartFile excelFile) throws Exception {
//        System.out.println(excelFile);
//
//        InputStream in = excelFile.getInputStream();
//        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(in);
//        HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
//        // 2.读取页脚sheet
//        HSSFSheet sheet = wb.getSheetAt(0);
//        int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();
//        System.out.println(coloumNum);
//
//        List<Map<String, Object>> list = new ArrayList<>();
//        //获取sheet的行数
//        int rows = sheet.getPhysicalNumberOfRows();
//        System.out.println("有行数" + sheet.getFirstRowNum());
//        System.out.println("有行数" + sheet.getLastRowNum());
//
//        for (int j = 1; j < sheet.getLastRowNum(); j++) {
//            Map<String, Object> map = new HashMap<>();
//            HSSFRow row = sheet.getRow(j);//行
//            // System.out.println(row.getPhysicalNumberOfCells());
//            System.out.println("有列数" + sheet.getRow(0).getLastCellNum());
//            if (null != row) {
//                for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
//                    HSSFCell cell = row.getCell(k);//列
//                    if (null != cell) {
//
//                        switch (cell.getCellType()) {
//                            case HSSFCell.CELL_TYPE_NUMERIC:// 数字
//                                if (DateUtil.isCellDateFormatted(cell)) {
//                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                                    String str = sdf.format(cell.getDateCellValue());
//                                    map.put(sheet.getRow(0).getCell(k).getStringCellValue(), str);
//                                } else {
//                                    map.put(sheet.getRow(0).getCell(k).getStringCellValue(), cell.getNumericCellValue());
//                                }
////                                System.out.print(cell.getNumericCellValue()
////                                        + "   ");
//
//                                break;
//                            case HSSFCell.CELL_TYPE_STRING:// 字符串
////                                System.out.print(cell.getStringCellValue()
////                                        + "   ");
//                                map.put(sheet.getRow(0).getCell(k).getStringCellValue(), cell.getStringCellValue());
//                                break;
//                            case HSSFCell.CELL_TYPE_BOOLEAN:// Boolean
////                                System.out.println(cell.getBooleanCellValue()
////                                        + "   ");
//                                map.put(sheet.getRow(0).getCell(k).getStringCellValue(), cell.getBooleanCellValue());
//                                break;
//                            case HSSFCell.CELL_TYPE_FORMULA:// 公式
////                                System.out.print(cell.getCellFormula() + "   ");
//                                map.put(sheet.getRow(0).getCell(k).getStringCellValue(), cell.getCellFormula());
//                                break;
//                            case HSSFCell.CELL_TYPE_BLANK:// 空值
////                                System.out.println(" ");
//                                map.put(sheet.getRow(0).getCell(k).getStringCellValue(), "");
//                                break;
//                            case HSSFCell.CELL_TYPE_ERROR:// 故障
////                                System.out.println(" ");
//                                map.put(sheet.getRow(0).getCell(k).getStringCellValue(), "");
//                                break;
//                            default:
////                                System.out.print("未知类型   ");
//                                map.put(sheet.getRow(0).getCell(k).getStringCellValue(), "");
//                                break;
//                        }
//
//                    } else {
//                        System.out.print("-   ");
//                        map.put(sheet.getRow(0).getCell(k).getStringCellValue(), "");
//                    }
//                }
//            }
//
//            list.add(map);
//            if (map.size() > 0) {
//                User u = new User();
//                System.out.println(map);
//                System.out.println(map.get("角色") == null);
//                System.out.println("".equals(map.get("角色")));
//
//                u.setUserName("".equals(map.get("姓名")) ? "" : map.get("姓名").toString());
//                u.setRole("".equals(map.get("角色")) ? "" : map.get("角色").toString());
//                u.setProfessional("".equals(map.get("职称")) ? "" : map.get("职称").toString());
//                u.setUserId("".equals(map.get("工号")) ? "" : map.get("工号").toString());
//                u.setDeptname("".equals(map.get("科室")) ? "" : map.get("科室").toString());
//                u.setIndate("".equals(map.get("入职日期")) ? "" : map.get("入职日期").toString());
//                ResponseEntity<Object>  result = userService.addUser(u);
//                if (result.getCode() != 200) {
//                    return result;
//                }
//            }
//        }
//
//        return new ResponseEntity<Object> (200, "删除成功", list);
//    }

    @RequestMapping("/queryUserAll")
    public ResponseEntity<Object>  queryUserAll( Map<String,Object> map){
        System.out.println(map);

        List<User> list = new ArrayList<>();
        list = userService.queryUserList("","","","");
        System.out.println(list);
        //根节点
        Map<String,Object> rootMenu = new HashedMap();
        rootMenu.put("id",1);
        rootMenu.put("label","在职人员");
        rootMenu.put("value","在职人员");
        List<Map<String,Object>> childList = new ArrayList<Map<String,Object>>();

        for ( User user: list) {
            Map<String,Object> childMenu = new HashedMap();
            childMenu.put("id",user.getUserId());
            childMenu.put("label",user.getUserName());
            childMenu.put("value",user.getUserName());
            childList.add(childMenu);
        }
        rootMenu.put("children",childList);
        List listRoot = new ArrayList();
        listRoot.add(rootMenu);
        return new ResponseEntity<Object> (PageUtil.toPage(listRoot,listRoot.size()), HttpStatus.OK);
    }



//    @RequestMapping("/tologin")
//    public String toLogin(){
//        return "/login";
//    }

//    @RequestMapping("/login")
//    public String login(String name, String password, Model model){
//        //获取subject
//        Subject subject = SecurityUtils.getSubject();
//        //封装用户数据
//        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
//        //执行登录方法
//        try {
//            //登录成功
//            subject.login(token);
//            return "redirect:/hello";
//        }catch (UnknownAccountException e){
//            //登录失败
////            e.printStackTrace();
//            model.addAttribute("msg","用户名不存在");
//            return "login";
//        }catch (IncorrectCredentialsException e){
//            model.addAttribute("msg","密码错误");
//            return "login";
//        }
//
//
//    }
//    @RequestMapping("/userlist")
//    @ResponseBody
//    public List<User> getUserList(){
//        return userService.getUserList();
//    }

//    @RequestMapping("/queryDicBySeq")
//    public CommonResult queryDicBySeq(@RequestBody Map<String,Object> map){
//        logger.info("queryDicBySeq",map);
//        String typeId =  map.get("typeId")==""?"":map.get("typeId").toString();
//        String typeId1 =  map.get("typeId")==""?"":map.get("typeId").toString();
//        System.out.println(typeId);
//        Map<Long,List<SystemDic>> result = new HashedMap();
//        List<SystemDic> list = commonService.queryDicDetailsBySeq(typeId);
//        list.forEach(e -> result.computeIfAbsent(e.getTplBaseId(), k -> new LinkedList<>()).add(e));
//        String json = JsonDataUtils.getJson(list);
//        JSONObject result = new JSONObject();
//        result.put("employees",list);
//        return new CommonResult(200, "成功", result);
//    }
}
