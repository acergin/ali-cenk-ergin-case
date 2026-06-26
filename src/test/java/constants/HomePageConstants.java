package constants;

import java.util.List;

public final class HomePageConstants {

    private HomePageConstants() {}

    public static final List<String> EXPECTED_SECTIONS = List.of(
            "homepage-hero",
            "homepage-social-proof",
            "homepage-capabilities",
            "homepage-insider-one-ai",
            "homepage-channels",
            "homepage-case-study",
            "homepage-analyst",
            "homepage-integrations",
            "homepage-resources",
            "homepage-call-to-action"
    );

    public static final List<String> EXPECTED_HEADER_ITEMS = List.of(
            "Platform",
            "Industries",
            "Customers",
            "Resources"
    );

    public static final List<String> EXPECTED_HEADER_TOP_ITEMS = List.of(
            "Partners",
            "Insider One Academy",
            "Help Center",
            "Contact Us"
    );

    public static final List<String> EXPECTED_HEADER_ACTIONS = List.of(
            "Platform Tour",
            "Get a demo"
    );
}