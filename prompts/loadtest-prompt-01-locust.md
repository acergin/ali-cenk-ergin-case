# Prompt Iteration 01 - Load Test Implementation

## Goal

Generate a simple load test for the search functionality of n11.com using Locust.

## Context provided

The assignment requires implementing a load test for the search module of n11.com.

The implementation should:
- use Locust
- simulate a user searching for a product
- keep the solution simple (1 user is sufficient)
- be easy to understand

## Prompt

Suggest a simple Locust implementation that performs a product search on n11.com and explain the basic Locust concepts used in the solution.

## Output evaluation

The generated implementation provided a good starting point for understanding the structure of a Locust test and the required HTTP requests.

During implementation, the generated solution was refined after verifying the actual search request using browser developer tools. The public website returned HTTP 403 responses because of bot protection, so the implementation and accompanying documentation were updated to explain this behavior instead of attempting to bypass it.

## Iteration notes

The final implementation was manually validated by inspecting the network traffic, confirming the correct search endpoint, and documenting the limitations caused by the target site's anti-bot protection.