# Common Pitfalls and Best Practices

This document highlights common issues when working with **HMITiles** and how to avoid them.

---

## 1. Missing `Sleep(1)` After Loading Layouts

### Problem
CustomViews may not initialize correctly if accessed immediately after loading a layout.

### Solution
Always add a short delay after `LoadLayout`:

```b4x
Root.LoadLayout("MainPage")
Sleep(1)
```
This allows the Designer to fully initialize CustomViews.

## 2. Confusing State vs SetState()

### Problem
Directly modifying State without updating visuals can lead to inconsistent UI behavior.

### Best Practice
- Use State to read the current state
- Use SetState() to change the state

```
TileButton.SetState(TileButton.State)
```

## 3. Forgetting to Update StateText

### Problem

Changing the button state without updating the label text leads to unclear operator feedback.

### Best Practice

Always update StateText after a state change:
```
TileButton.StateText = IIf(TileButton.State, "ON", "OFF")
```

## 4. Assuming All Tiles Work Identically on B4A and B4J

###Notes
- B4J is the primary target platform
- B4A supports most tiles but not all features
- Some tiles (e.g. RGB indicators) may be B4J-only

Always test on the target platform.

## 5. Over-Styling Tiles

### Guidance

HMITiles are designed for:
- clarity
- consistency
- minimal visual noise

Avoid:
- animations
- flashing effects
- excessive colors

Let the tile state convey meaning.

## 6. Using Tiles as Generic UI Widgets

### Reminder

HMITiles are HMI components, not general-purpose UI controls.

They are intended for:
- operator interaction
- process visibility
- state-based feedback

Not for:
- decorative UI
- consumer-style interfaces

## Summary

| Issue                | Recommendation        |
| -------------------- | --------------------- |
| Layout timing        | Always use `Sleep(1)` |
| State changes        | Use `SetState()`      |
| Feedback             | Update `StateText`    |
| Platform differences | Test per platform     |
| Styling              | Keep it minimal       |

For more details, see:
- GET_STARTED.md
- API.md
