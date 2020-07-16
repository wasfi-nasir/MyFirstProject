package com.example.interviews.dto;

import com.example.interviews.model.Candidate;
import com.example.interviews.model.Interviewer;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-16T11:45:12+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
public class ConverterImpl implements Converter {

    @Override
    public CandidateDTO convertCandidateToDto(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateDTO candidateDTO = new CandidateDTO();

        if ( candidate.getId() != null ) {
            candidateDTO.setId( candidate.getId() );
        }
        candidateDTO.setName( candidate.getName() );
        candidateDTO.setSubject( candidate.getSubject() );
        candidateDTO.setInterviewers( interviewerSetToCandidateInterviewersSet( candidate.getInterviewers() ) );

        return candidateDTO;
    }

    @Override
    public InterviewerDTO convertInterviewerToDto(Interviewer interviewer) {
        if ( interviewer == null ) {
            return null;
        }

        InterviewerDTO interviewerDTO = new InterviewerDTO();

        interviewerDTO.setName( interviewer.getName() );
        interviewerDTO.setPhone( interviewer.getPhone() );
        interviewerDTO.setCandidates( candidateSetToInterviewerCandidatesSet( interviewer.getCandidates() ) );

        return interviewerDTO;
    }

    protected CandidateInterviewers interviewerToCandidateInterviewers(Interviewer interviewer) {
        if ( interviewer == null ) {
            return null;
        }

        CandidateInterviewers candidateInterviewers = new CandidateInterviewers();

        if ( interviewer.getId() != null ) {
            candidateInterviewers.setId( interviewer.getId() );
        }
        candidateInterviewers.setName( interviewer.getName() );
        candidateInterviewers.setPhone( interviewer.getPhone() );

        return candidateInterviewers;
    }

    protected Set<CandidateInterviewers> interviewerSetToCandidateInterviewersSet(Set<Interviewer> set) {
        if ( set == null ) {
            return null;
        }

        Set<CandidateInterviewers> set1 = new HashSet<CandidateInterviewers>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Interviewer interviewer : set ) {
            set1.add( interviewerToCandidateInterviewers( interviewer ) );
        }

        return set1;
    }

    protected InterviewerCandidates candidateToInterviewerCandidates(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        InterviewerCandidates interviewerCandidates = new InterviewerCandidates();

        interviewerCandidates.setName( candidate.getName() );
        interviewerCandidates.setSubject( candidate.getSubject() );

        return interviewerCandidates;
    }

    protected Set<InterviewerCandidates> candidateSetToInterviewerCandidatesSet(Set<Candidate> set) {
        if ( set == null ) {
            return null;
        }

        Set<InterviewerCandidates> set1 = new HashSet<InterviewerCandidates>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Candidate candidate : set ) {
            set1.add( candidateToInterviewerCandidates( candidate ) );
        }

        return set1;
    }
}
