import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "subscriptions")
data class Subscription(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(nullable = false)
    val userId: Int,

    @Column(nullable = false)
    val startDate: LocalDate,

    @Column(nullable = false)
    val endDate: LocalDate,

    @Column(nullable = false)
    val nextBillingDate: LocalDate,

    @Column(nullable = false)
    val isActive: Boolean,

    @Column(nullable = false)
    val serviceId: Int,

    @Column(nullable = false)
    val serviceType: String
)
