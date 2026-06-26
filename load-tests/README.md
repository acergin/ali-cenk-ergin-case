The search endpoint was identified as GET /arama?q={keyword} via Chrome DevTools Network tab.
During local Locust execution, n11 may return 403 Forbidden due to bot protection/CDN rules.
The script still represents the expected load test scenario for the search listing flow.

Run the Load Test

Navigate to the load-tests directory and execute:

python3 -m locust -f locustfile.py

Then open:

http://localhost:8089

Recommended configuration:

* Host: https://www.n11.com
* Number of Users: 1
* Ramp up: 1