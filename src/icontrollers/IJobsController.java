/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author erik
 */
public interface IJobsController {
    public List<Job> getAll();
    public List<Job> getById(String id);
    public List<Job> search(String key);
    public String insert(String id, String Title, String Min_value, String Max_Value);
    public String update(String id, String Title, String Min_value, String Max_Value);
    public String delete(String id);
    
}
