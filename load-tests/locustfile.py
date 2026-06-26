from locust import HttpUser, task, between


class N11SearchUser(HttpUser):
    wait_time = between(1, 3)

    headers = {
        "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) "
                      "AppleWebKit/537.36 (KHTML, like Gecko) "
                      "Chrome/126.0.0.0 Safari/537.36",
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
        "Accept-Language": "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7",
        "Referer": "https://www.n11.com/"
    }

    @task
    def search_product(self):
        with self.client.get(
            "/arama",
            params={"q": "iphone"},
            headers=self.headers,
            name="/arama?q={keyword}",
            catch_response=True
        ) as response:
            if response.status_code == 200 and "iphone" in response.text.lower():
                response.success()
            else:
                response.failure(
                    f"Unexpected response. Status: {response.status_code}"
                )