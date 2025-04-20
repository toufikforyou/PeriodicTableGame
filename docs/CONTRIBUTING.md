# Contributing to Periodic Table Game

We love your input! We want to make contributing to Periodic Table Game as easy and transparent as possible.

## Development Process

We use GitHub to host code, to track issues and feature requests, as well as accept pull requests.

1. Fork the repo and create your branch from `main`
2. Make your changes
3. If you've added code that should be tested, add tests
4. Ensure the test suite passes
5. Make sure your code follows the project style guidelines
6. Issue a pull request

## Code Style Guidelines

- Follow the official Kotlin style guide
- Use meaningful variable and function names
- Write comments for complex logic
- Keep functions small and focused
- Use composition over inheritance
- Follow Material Design guidelines for UI components

## Pull Request Process

1. Update the README.md with details of changes if applicable
2. Update the CHANGELOG.md with notes on your changes
3. The PR will be merged once you have the sign-off of at least one other developer
4. Make sure all GitHub actions checks pass

## Project Structure

```
app/
├── src/
│   └── main/
│       ├── java/dev/toufikforyou/periodictable/
│       │   ├── di/          # Dependency injection
│       │   ├── main/
│       │   │   ├── data/    # Data layer
│       │   │   ├── domain/  # Domain layer
│       │   │   ├── presentation/ # UI layer
│       │   │   └── utils/   # Utility classes
│       │   └── ui/          # Theme and styling
│       └── res/             # Resources
```

## License

By contributing, you agree that your contributions will be licensed under the MIT License.
