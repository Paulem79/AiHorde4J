package net.paulem.aihorde4j.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Detailed information about a user.
 */
public record UserDetails(
        @SerializedName("username") String username,
        @SerializedName("id") Integer id,
        @SerializedName("kudos") Double kudos,
        @SerializedName("evaluating_kudos") Double evaluatingKudos,
        @SerializedName("concurrency") Integer concurrency,
        @SerializedName("worker_invited") Integer workerInvited,
        @SerializedName("moderator") Boolean moderator,
        @SerializedName("kudos_details") UserKudosDetails kudosDetails,
        @SerializedName("worker_count") Integer workerCount,
        @SerializedName("worker_ids") List<String> workerIds,
        @SerializedName("sharedkey_ids") List<String> sharedkeyIds,
        @SerializedName("monthly_kudos") MonthlyKudos monthlyKudos,
        @SerializedName("trusted") Boolean trusted,
        @SerializedName("flagged") Boolean flagged,
        @SerializedName("vpn") Boolean vpn,
        @SerializedName("service") Boolean service,
        @SerializedName("education") Boolean education,
        @SerializedName("special") Boolean special,
        @SerializedName("suspicious") Integer suspicious,
        @SerializedName("pseudonymous") Boolean pseudonymous,
        @SerializedName("contact") String contact,
        @SerializedName("admin_comment") String adminComment,
        @SerializedName("account_age") Integer accountAge,
        @SerializedName("usage") UsageDetails usage,
        @SerializedName("contributions") ContributionsDetails contributions,
        @SerializedName("records") UserRecords records
) {}
