package com.down.ssm.servlet;

import com.down.ssm.dao.DownInformationMapper;
import com.down.ssm.domain.DownInformation;
import com.down.ssm.service.impl.CRUDmapperImpl;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CRUDController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminview() {
        return new ModelAndView("admin", "downInformations", new DownInformation());
    }

    //REST风格实现方法

        /**
         * 查询所有
         *
*/

        @SneakyThrows
        @RequestMapping(value = "/admin/selectAll", method = RequestMethod.GET)
        public  String selectAll(HttpServletRequest request, HttpServletResponse response){

            //查询所有的数据，显示在jsp页面
            ApplicationContext act =
                    new ClassPathXmlApplicationContext("Beans.xml");

            DownInformationMapper downDao =
                    (DownInformationMapper) act.getBean("downInformationDao");

            List<DownInformation> downInformations=downDao.selectAll();


            String CRUDstring ="查询所有";
            request.setAttribute("CRUDstring",CRUDstring);
            request.setAttribute("downInformations", downInformations);
         //   request.getRequestDispatcher("/selectAll.jsp").forward(request,response);

            return "selectAll";
        }

        /**、
         * 根据ID查询
         *
         *
         */
        @RequestMapping(value = "/admin/selectone/{id}", method = RequestMethod.GET)
        public String selectDownInformationById(@PathVariable("id")Integer id,HttpServletRequest request){
            //查询id=？的数据，显示在jsp页面
            String CRUDstring ="查询一行";
            ApplicationContext act =
                    new ClassPathXmlApplicationContext("Beans.xml");

            DownInformationMapper downDao =
                    (DownInformationMapper) act.getBean("downInformationDao");

            DownInformation downInformations=downDao.selectByPrimaryKey(id);

            request.setAttribute("downInformations",downInformations);
            request.setAttribute("CRUDstring",CRUDstring);

            return "CRUDresult";
        }


        /**
         * 增加一个用户
         *
         */

        @RequestMapping(value = "/admin/insert", method = RequestMethod.POST)
        public String addDownInformation(@ModelAttribute("downInformations")DownInformation downInformations
                ,HttpServletRequest request){
            String CRUDstring ="增加一行";
            CRUDmapperImpl CRUDdown = new  CRUDmapperImpl();
            CRUDdown.insertone(downInformations);
            request.setAttribute("CRUDstring",CRUDstring);
            return "CRUDresult";
        }

        /**
         * 更新
         *
         */

        @RequestMapping(value = "/admin/update/{id}", method = RequestMethod.PUT)
        public String updateDownInformation(@ModelAttribute("downInformations")DownInformation downInformations,
                                            @PathVariable("id") Integer id,HttpServletRequest request){
            String CRUDstring ="修改一行";
            //修改id=？的数据
            downInformations.setDown_id(id);
            CRUDmapperImpl CRUDdown = new CRUDmapperImpl();
            CRUDdown.updataone(downInformations);

            ////查询资源是否修改,查询id=？的数据，显示在jsp页面
            ApplicationContext act =
                    new ClassPathXmlApplicationContext("Beans.xml");

            DownInformationMapper downDao =
                    (DownInformationMapper) act.getBean("downInformationDao");

            DownInformation downInformationLost=downDao.selectByPrimaryKey(id);
            request.setAttribute("CRUDstring",CRUDstring);
            request.setAttribute("downInformations",downInformationLost);
            return "CRUDresult";
        }

        /**
         * 删除
         *
         */


        @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.DELETE)
        public String deleDownInformation(@ModelAttribute("downInformations")DownInformation downInformations,
                                          @PathVariable("id") Integer id,HttpServletRequest request){

            String CRUDstring = "";
            request.setAttribute("CRUDstring",CRUDstring);


            CRUDmapperImpl CRUDdown = new CRUDmapperImpl();
            CRUDdown.deleteone(id);

            ////查询被删除的信息,查询id=？的数据，显示在jsp页面
            ApplicationContext act =
                    new ClassPathXmlApplicationContext("Beans.xml");

            DownInformationMapper downDao =
                    (DownInformationMapper) act.getBean("downInformationDao");

            if(downDao.selectByPrimaryKey(id)==null) {
                CRUDstring ="信息不存在，删除成功";
                request.setAttribute("CRUDstring",CRUDstring);
                return "deleteoneresult";

            }
            else {
                CRUDstring = "删除一行，删除失败";
                request.setAttribute("CRUDstring", CRUDstring);
                return "deleteoneresult";
            }
        }


}


