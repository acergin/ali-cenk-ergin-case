AI_USAGE.md

1. Explain the terms context, prompt, skill, and agent as they relate to AI coding assistants.

Context is the information provided to the AI before asking it to generate code, such as the project structure, technologies, coding conventions, and constraints. Better context usually leads to more relevant and accurate suggestions.

A prompt is the instruction or question given to the AI. The quality and level of detail in the prompt have a significant impact on the generated output.

A skill is a specific capability of an AI coding assistant, such as generating code, explaining existing code, reviewing implementations, or suggesting improvements.

An agent is an AI system that can perform a sequence of related tasks while keeping track of the overall objective. Instead of answering a single prompt, an agent can reason through multiple steps, make decisions, and iterate toward a solution.

⸻

2. How did you validate the AI output? Which parts did you reject and why?

I reviewed every AI-generated suggestion before adding it to the project and validated it by running the tests. I also compared the generated locators and assertions against the actual application using browser developer tools.

I rejected suggestions that did not follow the existing project conventions, such as brittle locators, direct Selenium calls inside Step Definitions, duplicated helper methods, or assumptions about URLs without verification. Those parts were manually refined to keep the framework consistent and maintainable.

⸻

3. Describe one point where the AI was weak in this task and how you solved it manually.

The AI was good at generating the overall project structure and boilerplate code, but it sometimes lacked awareness of the existing framework. For example, it suggested using Selenium’s native isDisplayed() and By locators instead of the reusable helper methods and @FindBy pattern already used throughout the project.

I resolved this by adapting the generated code to the project’s existing architecture, reusing BasePage methods, keeping the Page Object Model consistent, and manually verifying generated locators and navigation behavior.

⸻

4. In which situations would you prefer to write code manually instead of using AI?

I prefer writing code manually when implementing framework infrastructure, reusable utilities, or logic that requires a deep understanding of the existing project architecture. These parts benefit from consistency and long-term maintainability, where project-specific knowledge is more important than quickly generating code.

I find AI most valuable for brainstorming ideas, generating boilerplate code, learning unfamiliar technologies, and reviewing implementations. Even in those cases, I consider the generated output a starting point that should always be reviewed and validated before being committed.