# Examples

Example projects for the **HMITiles** library.

---

Welcome to the HMITiles examples collection.

This folder contains standalone and easy-to-follow examples for every tile and feature included in the library.

## Contents
### Tile Examples
- Each numbered subfolder contains a self-contained demo for a specific HMITile component.
- Reference Implementations
- Use the examples as a reference for properties, styling, status handling, layouts, and data integration.
### Application Demos
- More complete demo applications start at index 50-....

## Folder Structure
Examples are organized in numbered folders:

01-HMITile...
02-HMITile...
...
99-...

This numbering keeps the examples grouped and easy to navigate.

Simply open a project folder to see a tile in action and reuse the implementation patterns in your own applications.

---

## Notes

### B4A 13.50 (or higher) B4XPages Starter Service
The Starter service is being deprecated.
For existing B4XPages projects:
Remove Starter service
Add to the Main Module:
```
' Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
    Return True
End Sub
```

Example:
...

```
Sub Activity_Create(FirstTime As Boolean)
	Dim pm As B4XPagesManager
	pm.Initialize(Activity)
End Sub

Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

'Template version: B4A-N.NN
#Region Delegates
```
...
