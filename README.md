# CustomDialog
A customisable alternative for Android alert dialog.

## Download

```
implementation 'com.josephvuoto:CustomDialog:1.0.3'
```

## Example
- dialog with title

```
new CustomDialog.Builder(this)
        .setTitle("TITLE")
        .setMessage("MESSAGE, MESSAGE, MESSAGE, MESSAGE, MESSAGE, MESSAGE, MESSAGE, MESSAGE")
        .setOkButton("OK", dialog -> {
        Toast.makeText(this, "CLICKED OK", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        })
        .setCancelButton("CANCEL", dialog -> {
        Toast.makeText(this, "CLICKED CANCEL", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        })
        .build()
        .show();
```
![Screenshot_1](https://github.com/JosephVuoto/CustomDialog/blob/master/Screenshots/Screenshot_1.png)

- dialog without title

```
new CustomDialog.Builder(this)
        .setMessage("MESSAGE")
        .setOkButton("OK", dialog -> {
        Toast.makeText(this, "CLICKED OK", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        })
//                .setCancelButton("CANCEL", dialog ->
//                        Toast.makeText(this, "CLICKED CANCEL", Toast.LENGTH_SHORT).show())
        .build()
        .show();
```
![Screenshot_2](https://github.com/JosephVuoto/CustomDialog/blob/master/Screenshots/Screenshot_2.png)

- dialog with list

```
List<ListItemModel> listItemModels = new ArrayList<>();
listItemModels.add(new ListItemModel(R.drawable.ic_alarms, "Set Alarm"));
listItemModels.add(new ListItemModel(R.drawable.ic_insert_emoticon, "Insert Emoticon"));
listItemModels.add(new ListItemModel(R.drawable.ic_lock_open, "Open Lock"));
//        listItemModels.add(new ListItemModel("Set Alarm"));
//        listItemModels.add(new ListItemModel("Insert Emoticon"));
//        listItemModels.add(new ListItemModel("Open Lock"));
new ListDialog.Builder(this)
        .setDatas(listItemModels)
        .setColorText(getResources().getColor(R.color.colorAccent))
        .setColorImageTint(getResources().getColor(R.color.colorAccent))
        .setOnSelectListener((which, dialog) -> {
        Toast.makeText(this, "CLICKED " + which, Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        })
        .build()
        .show();
```
![Screenshot_3](https://github.com/JosephVuoto/CustomDialog/blob/master/Screenshots/Screenshot_3.png)

- dialog with custom view

```
LinearLayout customView = (LinearLayout) LayoutInflater.from(this)
        .inflate(R.layout.layout_custom, null, false);
new CustomViewDialog.Builder(this)
        .setOkButton("Done", Dialog::dismiss)
        .setCustomView(customView)
        .build()
        .show();
```
![Screenshot_4](https://github.com/JosephVuoto/CustomDialog/blob/master/Screenshots/Screenshot_4.png)

- loading dialog

```
new LoadingDialog.Builder(this)
        .setLoadingText("now loading...")
        .setTextColor(Color.parseColor("#DDDDDD"))
        .setCanceledOnTouchOutside(false)
        .build()
        .show();
```
![Screenshot_5](https://github.com/JosephVuoto/CustomDialog/blob/master/Screenshots/Screenshot_5.png)
