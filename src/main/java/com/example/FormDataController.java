//package com.example;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
///**
// * Created by hillaryskye on 2/19/17.
// */
//
//@RestController
//public class FormDataController {
//
//    @PostMapping("/individual-example")
//    public String getIndividualParams(@RequestParam int classId, @RequestParam String taughtBy) {
//        return String.format("%s is teaching class:%d", classId, taughtBy);
//    }
//
//    @PostMapping("/map")
//    public String postRequestBodyAsMap(@RequestParam Map<String, String> formData) {
//        return formData.toString();
//    }
//
//    @PostMapping("/object-example")
//    public String showFormDataObject(Class c) {
//        return String.format("%s taughtt %d", c.getTaughtBy(), c.getClassId());
//    }
//
//        public static class Class {
//
//
//            private int classId;
//
//            public int getClassId() {
//                return classId;
//            }
//
//            public void setClassId(int classId) {
//                this.classId = classId;
//            }
//
//            public String getTaughtBy() {
//                return taughtBy;
//            }
//
//            public void setTaughtBy(String taughtBy) {
//                this.taughtBy = taughtBy;
//            }
//
//            private String taughtBy;
//        }
//}

package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hillary skye on 2/19/17.
 */
@RestController
public class FormDataController {

    @PostMapping("/individual-example")
    public String getIndividualParams(@RequestParam int classId, @RequestParam String instructor) {
        return String.format("instructor:%s classId:%d", instructor, classId);
    }

    @PostMapping("/map")
    public String postRequestBodyAsMap(@RequestParam Map<String, String> map) {
        return map.toString();
    }

    @PostMapping("/object-example")
    public String showFormDataObject(Class c) {
        return String.format("instructor:%s classId:%d", c.getInstructor(), c.getClassId());
    }

    public static class Class {
        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public String getInstructor() {
            return instructor;
        }

        public void setInstructor(String instructor) {
            this.instructor = instructor;
        }

        private int classId;
        private String instructor;
    }
}