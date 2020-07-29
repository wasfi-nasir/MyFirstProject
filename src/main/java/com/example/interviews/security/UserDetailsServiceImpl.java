package com.example.interviews.security;
 
import com.example.interviews.model.Interviewer;
import com.example.interviews.repo.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
 
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private InterviewerRepository interviewerRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Interviewer user = interviewerRepository.getInterviewerByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
}