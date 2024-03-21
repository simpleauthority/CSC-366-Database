package test.java.edu.calpoly.csc366.teamdatabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import jakarta.persistence.EntityManager;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class OwnerBoardDirectorTests {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BoardMemberRepository boardMemberRepository;

    @Autowired
    private BoardMeetingsRepository boardMeetingsRepository;

    @Autowired
    private CompanyPerformanceRepository companyPerformanceRepository;

    @Autowired
    private FinancialStatementsRepository financialStatementsRepository;

    @Autowired
    private ShareholderEngagementRepository shareholderEngagementRepository;

    @Autowired
    private StrategicInitiativesRepository strategicInitiativesRepository;

    private Date testDate = new Date();

    @BeforeEach
    public void setup() {
        BoardMember boardMember = new BoardMember("John", "Doe", null, testDate, testDate, "1234567890");
        boardMember = boardMemberRepository.saveAndFlush(boardMember);

        BoardMeetings boardMeeting = new BoardMeetings(testDate, boardMember, "Agenda", "Decisions", "Action Items");
        boardMeetingsRepository.saveAndFlush(boardMeeting);

        CompanyPerformance companyPerformance = new CompanyPerformance(testDate, 100000, 20, 5.0f);
        companyPerformanceRepository.saveAndFlush(companyPerformance);

        FinancialStatements financialStatements = new FinancialStatements("Type", testDate, 500000, 300000, 200000, boardMember);
        financialStatementsRepository.saveAndFlush(financialStatements);

        ShareholderEngagement shareholderEngagement = new ShareholderEngagement(boardMeeting, testDate, "Feedback", "Communication");
        shareholderEngagementRepository.saveAndFlush(shareholderEngagement);

        StrategicInitiatives strategicInitiatives = new StrategicInitiatives("Title", "Description", testDate, testDate, "Status", boardMeeting);
        strategicInitiativesRepository.saveAndFlush(strategicInitiatives);
    }

    @Test
    public void testBoardMemberPersistence() {
        BoardMember retrievedBoardMember = boardMemberRepository.findById(1).orElse(null);
        assertNotNull(retrievedBoardMember);
        assertEquals("John", retrievedBoardMember.getFirstName());
    }

    @Test
    public void testBoardMeetingsPersistence() {
        BoardMeetings retrievedBoardMeeting = boardMeetingsRepository.findById(1).orElse(null);
        assertNotNull(retrievedBoardMeeting);
        assertEquals("Agenda", retrievedBoardMeeting.getAgenda());
    }

    @Test
    public void testCompanyPerformancePersistence() {
        CompanyPerformance retrievedPerformance = companyPerformanceRepository.findAll().get(0);
        assertNotNull(retrievedPerformance);
        assertEquals(100000, retrievedPerformance.getRevenue());
        assertEquals(20, retrievedPerformance.getProfitMargin());
        assertEquals(5.0f, retrievedPerformance.getGrowthRate(), 0.001);
    }

    @Test
    public void testFinancialStatementsPersistence() {
        FinancialStatements retrievedStatement = financialStatementsRepository.findAll().get(0);
        assertNotNull(retrievedStatement);
        assertEquals("Type", retrievedStatement.getType());
        assertEquals(500000, retrievedStatement.getTotalAssets());
        assertEquals(300000, retrievedStatement.getTotalLiabilities());
        assertEquals(200000, retrievedStatement.getNetIncome());
    }

    @Test
    public void testShareholderEngagementPersistence() {
        ShareholderEngagement retrievedEngagement = shareholderEngagementRepository.findAll().get(0);
        assertNotNull(retrievedEngagement);
        assertEquals("Feedback", retrievedEngagement.getFeedback());
        assertEquals("Communication", retrievedEngagement.getCommunication());
        assertNotNull(retrievedEngagement.getBoardMeeting());
    }

    @Test
    public void testStrategicInitiativesPersistence() {
        StrategicInitiatives retrievedInitiative = strategicInitiativesRepository.findAll().get(0);
        assertNotNull(retrievedInitiative);
        assertEquals("Title", retrievedInitiative.getTitle());
        assertEquals("Description", retrievedInitiative.getDescription());
        assertEquals("Status", retrievedInitiative.getStatus());
        assertNotNull(retrievedInitiative.getBoardMeeting());
    }


}
